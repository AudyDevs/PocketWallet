package com.example.pocketwallet.domain.usecase

import com.example.pocketwallet.domain.WalletRepository
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.ANY_ID
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class DeleteWalletUseCaseTest {

    @MockK
    private lateinit var walletRepository: WalletRepository
    private lateinit var deleteWalletUseCase: DeleteWalletUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        deleteWalletUseCase = DeleteWalletUseCase(walletRepository)
    }

    @Test
    fun `when DeleteWalletUseCase is called successfully, WalletRepository should call deleteWallet once`() =
        runBlocking {
            //Given
            val anyID = ANY_ID
            coEvery { walletRepository.deleteWallet(anyID) } just runs

            //When
            deleteWalletUseCase.invoke(anyID)

            //Then
            coVerify(exactly = 1) { walletRepository.deleteWallet(anyID) }
        }
}