package com.example.pocketwallet.di

import android.content.Context
import androidx.room.Room
import com.example.pocketwallet.core.Constants.ROOM_DATABASE_NAME
import com.example.pocketwallet.data.WalletRepositoryImpl
import com.example.pocketwallet.data.room.DataBase
import com.example.pocketwallet.data.room.dao.WalletDao
import com.example.pocketwallet.domain.WalletRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DataBase::class.java, ROOM_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideWalletDao(db: DataBase) = db.loadWalletDao()

    @Provides
    fun provideWalletRepository(walletDao: WalletDao): WalletRepository {
        return WalletRepositoryImpl(walletDao)
    }
}