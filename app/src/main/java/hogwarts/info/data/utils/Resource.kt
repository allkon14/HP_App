package hogwarts.info.data.utils

sealed class Resource<T>(val data: T? = null, val errorMessage: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(errorType: String) : Resource<T>(null, errorType)
    class Loading<T> : Resource<T>(null, null)
}