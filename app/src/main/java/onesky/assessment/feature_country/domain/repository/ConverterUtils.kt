package onesky.assessment.feature_country.domain.repository

import onesky.assessment.feature_country.domain.network.ResultData
import retrofit2.HttpException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object ConverterUtils {
    suspend fun <T> createResultData(
        e: java.lang.Exception,
        apiCall: suspend () -> T?
    ): ResultData<T> {
        return try {
            if (apiCall.invoke() != null){
                ResultData.Success(apiCall.invoke())
            }else{
                when (e) {
                    is IOException ->{
                        ResultData.Failed("Network Error!")
                    }
                    is HttpException -> {
                        val errorResponse = convertErrorBody(e)
                        ResultData.Failed(errorResponse)
                    }
                    else -> {
                        ResultData.Failed(null)
                    }
                }
            }
        } catch (throwable: Throwable) {
            ResultData.Failed(throwable.message)
        }
    }

    private fun convertErrorBody(throwable: HttpException): String? {
        return try {
            val body = throwable.response()!!.errorBody()
            convertStreamToString(body?.byteStream()!!)
        } catch (e : Exception){
            null
        }
    }
    private fun convertStreamToString(inputStream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val sb = StringBuilder()
        var line: String? = null
        try {
            while (reader.readLine().also { line = it } != null) {
                sb.append(line).append('\n')
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return sb.toString()
    }
}