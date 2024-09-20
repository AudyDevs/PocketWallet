package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyListWalletModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetWalletsUseCaseTest {

    @MockK
    private lateinit var walletRepository: WalletRepository
    private lateinit var getWalletsUseCase: GetWalletsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getWalletsUseCase = GetWalletsUseCase(walletRepository)
    }

    @Test
    fun `when GetWalletsUseCase is called successfully, WalletRepository should return a correct list of WalletModel`() {
        runBlocking {
            //Given
            val anyListWalletModel = anyListWalletModel
            coEvery { walletRepository.getWallets() } returns anyListWalletModel

            //When
            val listWalletModel = getWalletsUseCase.invoke()

            //Then
            assert(listWalletModel == anyListWalletModel)
        }
    }

    @Test
    fun `when GetWalletsUseCase is called successfully, WalletRepository should call getWallets once`() {
        runBlocking {
            //Given
            val anyListWalletModel = anyListWalletModel
            coEvery { walletRepository.getWallets() } returns anyListWalletModel

            //When
            getWalletsUseCase.invoke()

            //Then
            coVerify(exactly = 1) { walletRepository.getWallets() }
        }
    }
}