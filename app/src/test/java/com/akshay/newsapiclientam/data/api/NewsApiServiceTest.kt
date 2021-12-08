package com.akshay.newsapiclientam.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var service: NewsApiService
    private lateinit var server:MockWebServer

    @Before
    fun setup() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    private fun enqueueMockResponse(
        fileName:String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer() // set it into memory buffer
        val mockRespons = MockResponse()
        mockRespons.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockRespons)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("in",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            // country=in&apiKey=f32810135f364627b1fedc321ab5a352&page=1
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=in&page=1&apiKey=f32810135f364627b1fedc321ab5a352")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("in",1).body()
            val articleList = responseBody!!.articles
            assertThat(articleList!!.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("in",1).body()
            val articleList = responseBody!!.articles
            val article = articleList!![0]
            assertThat(article.author).isEqualTo("PTI")
            assertThat(article.url).isEqualTo("https://timesofindia.indiatimes.com/sports/cricket/new-zealand-in-india/india-vs-new-zealand-kl-rahul-ruled-out-test-series-suryakumar-yadav-added-to-squad/articleshow/87868478.cms")
            assertThat(article.publishedAt).isEqualTo("2021-11-23T13:17:00Z")
        }
    }

}