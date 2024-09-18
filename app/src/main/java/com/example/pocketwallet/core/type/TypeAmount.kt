package com.example.pocketwallet.core.type

import com.example.pocketwallet.R

enum class TypeAmount(val id: Int, val title: Int, val image: Int) {
    Shopping(1, R.string.type_shopping, R.drawable.ic_shopping),
    Food(2, R.string.type_food, R.drawable.ic_food),
    Restaurants(3, R.string.type_restaurant, R.drawable.ic_restaurant),
    Entertainment(4, R.string.type_entertainment, R.drawable.ic_entertainment),
    Education(5, R.string.type_education, R.drawable.ic_education),
    Beauty(6, R.string.type_beauty, R.drawable.ic_beauty),
    Sports(7, R.string.type_sports, R.drawable.ic_sports),
    Social(8, R.string.type_social, R.drawable.ic_social),
    Transport(9, R.string.type_transport, R.drawable.ic_transport),
    Clothes(10, R.string.type_clothes, R.drawable.ic_clothes),
    Car(11, R.string.type_car, R.drawable.ic_car),
    Tobacco(12, R.string.type_tobacco, R.drawable.ic_tobacco),
    Electronics(13, R.string.type_electronics, R.drawable.ic_electronics),
    Trips(14, R.string.type_trips, R.drawable.ic_trips),
    Health(15, R.string.type_health, R.drawable.ic_health),
    Pet(16, R.string.type_pet, R.drawable.ic_pet),
    Repair(17, R.string.type_repair, R.drawable.ic_repair),
    Home(18, R.string.type_home, R.drawable.ic_home),
    Gift(19, R.string.type_gift, R.drawable.ic_gift),
    Family(20, R.string.type_family, R.drawable.ic_family);

    companion object {
        fun getTypeAmountById(id: Int): TypeAmount? {
            return values().find { it.id == id }
        }
    }
}

