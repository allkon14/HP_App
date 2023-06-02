package hogwarts.info.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hogwarts.info.data.api.HogwartsApi
import hogwarts.info.data.repo.HogwartsRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideHogwartsRepository(hogwartsApi: HogwartsApi): HogwartsRepository {
        return HogwartsRepository(hogwartsApi)
    }

    @Provides
    fun provideHogwartsApi(retrofit: Retrofit): HogwartsApi {
        return retrofit.create(HogwartsApi::class.java)
    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}