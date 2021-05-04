/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.stream.DoubleStream.builder

private const val BASE_URL = "https://mars.udacity.com/"

// TODO (02) Use Retrofit Builder with ScalarsConverterFactory and BASE_URL //DONE
private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
// TODO (03) Implement the MarsApiService interface with @GET getProperties returning a String //DONE
interface MarsApiService {
    @GET("realestate")
    fun getProperties():
            /*
            * Call<T> sends a request to a webserver and returns a response.*/
            Call<String>
}
// TODO (04) Create a MarsApi public object to expose the Retrofit service to the rest of the app //DONE
//  using Retrofit to implement the MarsApiService

/*
* object declares and creates a singleton. Since we only need one retrofit service instance (and it
* is an expensive (network) call), we only create it once
*/
object MarsApi {
    /*
    * lazy initialization is the tactic of delaying the creation of the object until the time it is
    * first needed
    */
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}
