package com.example.pocketwallet.presentation.viewmodel

import com.example.pocketwallet.dispatcher.DispatcherRule
import com.example.pocketwallet.dispatcher.TestDispatchers
import com.example.pocketwallet.domain.usecase.GetWalletsUseCase
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyListWalletModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @MockK
    private lateinit var getWalletsUseCase: GetWalletsUseCase

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var testDispatchers: TestDispatchers

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        testDispatchers = TestDispatchers()
        homeViewModel = HomeViewModel(
            testDispatchers,
            getWalletsUseCase
        )
    }

    @Test
    fun `when HomeViewModel calls getWallets successfully, it should call getWalletsUseCase once`() =
        runBlocking {
            //Given
            val anyListWalletModel = anyListWalletModel
            coEvery { getWalletsUseCase.invoke() } returns anyListWalletModel

            //When
            homeViewModel.getWallets()
            testDispatchers.testDispatchers.scheduler.advanceUntilIdle()

            //Then
            coVerify(exactly = 1) { getWalletsUseCase.invoke() }
        }
}