package com.example.pocketwallet.presentation.viewmodel

import com.example.pocketwallet.dispatcher.DispatcherRule
import com.example.pocketwallet.dispatcher.TestDispatchers
import com.example.pocketwallet.domain.usecase.DeleteWalletUseCase
import com.example.pocketwallet.domain.usecase.GetWalletIdUseCase
import com.example.pocketwallet.domain.usecase.InsertWalletUseCase
import com.example.pocketwallet.domain.usecase.UpdateWalletUseCase
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.ANY_ID
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @MockK
    private lateinit var getWalletIdUseCase: GetWalletIdUseCase

    @MockK
    private lateinit var insertWalletUseCase: InsertWalletUseCase

    @MockK
    private lateinit var updateWalletUseCase: UpdateWalletUseCase

    @MockK
    private lateinit var deleteWalletUseCase: DeleteWalletUseCase

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        testDispatchers = TestDispatchers()
        detailViewModel = DetailViewModel(
            testDispatchers,
            getWalletIdUseCase,
            insertWalletUseCase,
            updateWalletUseCase,
            deleteWalletUseCase
        )
    }

    @Test
    fun `when DetailViewModel calls getWalletId successfully, it should call getWalletIdUseCase once`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            val anyID = ANY_ID
            coEvery { getWalletIdUseCase.invoke(anyID) } returns anyWalletModel

            //When
            detailViewModel.getWalletId(anyID)
            testDispatchers.testDispatchers.scheduler.advanceUntilIdle()

            //Then
            coVerify(exactly = 1) { getWalletIdUseCase.invoke(anyID) }
        }

    @Test
    fun `when DetailViewModel calls insertWallet successfully, it should call insertWalletUseCase once`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            coEvery { insertWalletUseCase.invoke(anyWalletModel) } just runs

            //When
            detailViewModel.insertWallet(anyWalletModel)
            testDispatchers.testDispatchers.scheduler.advanceUntilIdle()

            //Then
            coVerify(exactly = 1) { insertWalletUseCase.invoke(anyWalletModel) }
        }

    @Test
    fun `when DetailViewModel calls updateWallet successfully, it should call updateWalletUseCase once`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletModel
            coEvery { updateWalletUseCase.invoke(anyWalletModel) } just runs

            //When
            detailViewModel.updateWallet(anyWalletModel)
            testDispatchers.testDispatchers.scheduler.advanceUntilIdle()

            //Then
            coVerify(exactly = 1) { updateWalletUseCase.invoke(anyWalletModel) }
        }

    @Test
    fun `when DetailViewModel calls deleteWallet successfully, it should call deleteWalletUseCase once`() =
        runBlocking {
            //Given
            val anyID = ANY_ID
            coEvery { deleteWalletUseCase.invoke(anyID) } just runs

            //When
            detailViewModel.deleteWallet(anyID)
            testDispatchers.testDispatchers.scheduler.advanceUntilIdle()

            //Then
            coVerify(exactly = 1) { deleteWalletUseCase.invoke(anyID) }
        }
}