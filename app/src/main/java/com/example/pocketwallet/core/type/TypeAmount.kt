package com.example.pocketwallet.core.type

import androidx.compose.ui.graphics.Color
import com.example.pocketwallet.R
import com.example.pocketwallet.presentation.ui.theme.TypeBeauty
import com.example.pocketwallet.presentation.ui.theme.TypeCar
import com.example.pocketwallet.presentation.ui.theme.TypeClothes
import com.example.pocketwallet.presentation.ui.theme.TypeEducation
import com.example.pocketwallet.presentation.ui.theme.TypeElectronics
import com.example.pocketwallet.presentation.ui.theme.TypeEntertainment
import com.example.pocketwallet.presentation.ui.theme.TypeFamily
import com.example.pocketwallet.presentation.ui.theme.TypeFood
import com.example.pocketwallet.presentation.ui.theme.TypeGift
import com.example.pocketwallet.presentation.ui.theme.TypeHealth
import com.example.pocketwallet.presentation.ui.theme.TypeHome
import com.example.pocketwallet.presentation.ui.theme.TypePet
import com.example.pocketwallet.presentation.ui.theme.TypeRepair
import com.example.pocketwallet.presentation.ui.theme.TypeRestaurants
import com.example.pocketwallet.presentation.ui.theme.TypeShopping
import com.example.pocketwallet.presentation.ui.theme.TypeSocial
import com.example.pocketwallet.presentation.ui.theme.TypeSports
import com.example.pocketwallet.presentation.ui.theme.TypeTobacco
import com.example.pocketwallet.presentation.ui.theme.TypeTransport
import com.example.pocketwallet.presentation.ui.theme.TypeTrips

enum class TypeAmount(val id: Int, val title: Int, val image: Int, val color: Color) {
    Shopping(1, R.string.type_shopping, R.drawable.ic_shopping, TypeShopping),
    Food(2, R.string.type_food, R.drawable.ic_food, TypeFood),
    Restaurants(3, R.string.type_restaurant, R.drawable.ic_restaurant, TypeRestaurants),
    Entertainment(4, R.string.type_entertainment, R.drawable.ic_entertainment, TypeEntertainment),
    Education(5, R.string.type_education, R.drawable.ic_education, TypeEducation),
    Beauty(6, R.string.type_beauty, R.drawable.ic_beauty, TypeBeauty),
    Sports(7, R.string.type_sports, R.drawable.ic_sports, TypeSports),
    Social(8, R.string.type_social, R.drawable.ic_social, TypeSocial),
    Transport(9, R.string.type_transport, R.drawable.ic_transport, TypeTransport),
    Clothes(10, R.string.type_clothes, R.drawable.ic_clothes, TypeClothes),
    Car(11, R.string.type_car, R.drawable.ic_car, TypeCar),
    Tobacco(12, R.string.type_tobacco, R.drawable.ic_tobacco, TypeTobacco),
    Electronics(13, R.string.type_electronics, R.drawable.ic_electronics, TypeElectronics),
    Trips(14, R.string.type_trips, R.drawable.ic_trips, TypeTrips),
    Health(15, R.string.type_health, R.drawable.ic_health, TypeHealth),
    Pet(16, R.string.type_pet, R.drawable.ic_pet, TypePet),
    Repair(17, R.string.type_repair, R.drawable.ic_repair, TypeRepair),
    Home(18, R.string.type_home, R.drawable.ic_home, TypeHome),
    Gift(19, R.string.type_gift, R.drawable.ic_gift, TypeGift),
    Family(20, R.string.type_family, R.drawable.ic_family, TypeFamily);

    companion object {
        fun getTypeAmountById(id: Int): TypeAmount? {
            return entries.find { it.id == id }
        }
    }
}

