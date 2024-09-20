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

class UpdateWalletUseCaseTest {

    @MockK
    private lateinit var walletRepository: WalletRepository
    private lateinit var updateWalletUseCase: UpdateWalletUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        updateWalletUseCase = UpdateWalletUseCase(walletRepository)
    }

    @Test
    fun `when UpdateWalletUseCase is called successfully, WalletRepository should call updateWallet once`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            coEvery { walletRepository.updateWallet(anyWalletModel) } just runs

            //When
            updateWalletUseCase.invoke(anyWalletModel)

            //Then
            coVerify(exactly = 1) { walletRepository.updateWallet(anyWalletModel) }
        }
}