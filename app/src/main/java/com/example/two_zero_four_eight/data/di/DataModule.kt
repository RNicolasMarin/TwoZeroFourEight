package com.example.two_zero_four_eight.data.di

import android.content.Context
import com.example.two_zero_four_eight.data.local.TwoZeroFourEightDatabase
import com.example.two_zero_four_eight.data.local.daos.RecordDao
import com.example.two_zero_four_eight.data.repositories.RecordRepositoryImpl
import com.example.two_zero_four_eight.domain.repositories.RecordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun getTwoZeroFourEightDatabase(@ApplicationContext appContext: Context) =
        TwoZeroFourEightDatabase.getInstance(appContext)

    @Provides
    fun provideRecordDao(db: TwoZeroFourEightDatabase) =
        db.recordDao()

    @Provides
    fun provideRecordRepository(dao: RecordDao): RecordRepository =
        RecordRepositoryImpl(dao)
}