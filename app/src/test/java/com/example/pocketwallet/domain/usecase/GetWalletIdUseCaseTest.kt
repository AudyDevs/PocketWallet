package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.ANY_ID
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetWalletIdUseCaseTest {

    @MockK
    private lateinit var walletRepository: WalletRepository
    private lateinit var getWalletIdUseCase: GetWalletIdUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getWalletIdUseCase = GetWalletIdUseCase(walletRepository)
    }

    @Test
    fun `when GetWalletIdUseCase is called successfully, WalletRepository should return a correct WalletModel`() {
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            val anyID = ANY_ID
            coEvery { walletRepository.getWalletId(anyID) } returns anyWalletModel

            //When
            val walletModel = getWalletIdUseCase.invoke(anyID)

            //Then
            assert(walletModel == anyWalletModel)
        }
    }

    @Test
    fun `when GetWalletIdUseCase is called successfully, WalletRepository should call getWalletId once`() {
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            val anyID = ANY_ID
            coEvery { walletRepository.getWalletId(anyID) } returns anyWalletModel

            //When
            getWalletIdUseCase.invoke(anyID)

            //Then
            coVerify(exactly = 1) { walletRepository.getWalletId(anyID) }
        }
    }
}