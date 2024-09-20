package com.example.pocketwallet.data

import com.example.pocketwallet.core.mappers.toDomain
import com.example.pocketwallet.core.mappers.toRoom
import com.example.pocketwallet.data.room.dao.WalletDao
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.ANY_ID
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyListWalletEntity
import com.example.pocketwallet.motherobject.PocketWalletMotherObject.anyWalletEntity
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

class WalletRepositoryImplTest {

    @MockK
    private lateinit var walletDao: WalletDao
    private lateinit var walletRepositoryImpl: WalletRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        walletRepositoryImpl = WalletRepositoryImpl(walletDao)
    }

    @Test
    fun `when WalletRepositoryImpl call getWallets successfully, it should return a correct list of WalletModel`() =
        runBlocking {
            //Given
            val anyListWalletModel = anyListWalletEntity.map { it.toDomain() }
            coEvery { walletDao.getWallets() } returns anyListWalletEntity

            //When
            val listWalletModel = walletRepositoryImpl.getWallets()

            //Then
            assert(listWalletModel == anyListWalletModel)
        }

    @Test
    fun `when WalletRepositoryImpl call getWallets successfully, it should call getWallets from WalletDao once`() =
        runBlocking {
            //Given
            coEvery { walletDao.getWallets() } returns anyListWalletEntity

            //When
            walletRepositoryImpl.getWallets()

            //Then
            coVerify(exactly = 1) { walletDao.getWallets() }
        }

    @Test
    fun `when WalletRepositoryImpl call getWalletId successfully, it should return a correct WalletModel`() =
        runBlocking {
            //Given
            val anyWalletModel = anyWalletEntity.toDomain()
            val anyID = ANY_ID
            coEvery { walletDao.getWalletID(anyID) } returns anyWalletEntity

            //When
            val walletModel = walletRepositoryImpl.getWalletId(anyID)

            //Then
            assert(walletModel == anyWalletModel)
        }

    @Test
    fun `when WalletRepositoryImpl call getWalletId successfully, it should call getWalletId from WalletDao once`() =
        runBlocking {
            //Given
            val anyID = ANY_ID
            coEvery { walletDao.getWalletID(anyID) } returns anyWalletEntity

            //When
            walletRepositoryImpl.getWalletId(anyID)

            //Then
            coVerify(exactly = 1) { walletDao.getWalletID(anyID) }
        }

    @Test
    fun `when WalletRepositoryImpl call insertWallet successfully, it should call insertWallet from WalletDao once`() =
        runBlocking {
            //Given
            val walletEntity = anyWalletModel.toRoom()
            coEvery { walletDao.insertWallet(walletEntity) } just runs

            //When
            walletRepositoryImpl.insertWallet(anyWalletModel)

            //Then
            coVerify(exactly = 1) { walletDao.insertWallet(walletEntity) }
        }

    @Test
    fun `when WalletRepositoryImpl call updateWallet successfully, it should call updateWallet from WalletDao once`() =
        runBlocking {
            //Given
            val walletEntity = anyWalletModel.toRoom()
            coEvery { walletDao.updateWallet(walletEntity) } just runs

            //When
            walletRepositoryImpl.updateWallet(anyWalletModel)

            //Then
            coVerify(exactly = 1) { walletDao.updateWallet(walletEntity) }
        }

    @Test
    fun `when WalletRepositoryImpl call deleteWallet successfully, it should call deleteWallet from WalletDao once`() =
        runBlocking {
            //Given
            val anyID = ANY_ID
            coEvery { walletDao.deleteWallet(anyID) } just runs

            //When
            walletRepositoryImpl.deleteWallet(anyID)

            //Then
            coVerify(exactly = 1) { walletDao.deleteWallet(anyID) }
        }
}