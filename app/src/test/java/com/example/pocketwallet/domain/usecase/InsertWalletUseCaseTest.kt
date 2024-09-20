package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class InsertWalletUseCaseTest {

    @MockK
    private lateinit var walletRepository: WalletRepository
    private lateinit var insertWalletUseCase: InsertWalletUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        insertWalletUseCase = InsertWalletUseCase(walletRepository)
    }

    @Test
    fun `when InsertWalletUseCase is called successfully, WalletRepository should call insertWallet once`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            coEvery { walletRepository.insertWallet(anyWalletModel) } just runs

            //When
            insertWalletUseCase.invoke(anyWalletModel)

            //Then
            coVerify(exactly = 1) { walletRepository.insertWallet(anyWalletModel) }
        }
}