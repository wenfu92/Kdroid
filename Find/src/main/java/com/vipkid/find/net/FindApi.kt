package com.vipkid.find.net

import com.howshea.basemodule.web.retrofit
import com.vipkid.find.model.History
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by WWF
 * on 2019/5/4
 */
interface FindApi {
    @GET("history/content/{count}/{page}")
    fun getHistory(
            @Path("count") count: Int,
            @Path("page") page: Int
    ): Observable<History>

}
object FindApiService : FindApi by retrofit.create(FindApi::class.java)