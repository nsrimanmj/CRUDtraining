package com.example.crudtraining.di

import android.os.Build
import androidx.core.os.BuildCompat
import com.example.crudtraining.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object SupabaseModule{
    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient{
        return createSupabaseClient(
            supabaseKey = BuildConfig.SUPABASE_ANON_KEY,
            supabaseUrl = BuildConfig.SUPABASE_URL
        ){
            install(Postgrest)
        }
    }
    @Provides
    @Singleton
    fun provideSupabaseDatabase(client: SupabaseClient): Postgrest {
        return client.postgrest
    }
}