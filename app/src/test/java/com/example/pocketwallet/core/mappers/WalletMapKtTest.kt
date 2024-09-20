package com.example.pocketwallet.core.mappers

import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletEntity
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletModel
import io.kotlintest.shouldBe
import org.junit.Test

class WalletMapKtTest {

    @Test
    fun `toRoom should return a correct WalletEntity`() {
        //Given
        val walletModel = anyWalletModel

        //When
        val walletEntity = walletModel.toRoom()

        //Then
        walletModel.id shouldBe walletEntity.id
        walletModel.date shouldBe walletEntity.date
        walletModel.type shouldBe walletEntity.type
        walletModel.amount shouldBe walletEntity.amount
        walletModel.note shouldBe walletEntity.note
    }

    @Test
    fun `toDomain should return a correct WalletModel`() {
        //Given
        val walletEntity = anyWalletEntity

        //When
        val walletModel = walletEntity.toDomain()

        //Then
        walletEntity.id shouldBe walletModel.id
        walletEntity.date shouldBe walletModel.date
        walletEntity.type shouldBe walletModel.type
        walletEntity.amount shouldBe walletModel.amount
        walletEntity.note shouldBe walletModel.note
    }
}