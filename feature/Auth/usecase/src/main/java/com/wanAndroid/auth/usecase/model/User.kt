package com.wanAndroid.auth.usecase.model

//register callback
// userName:lujunjie, password:123456
/*{
    "data": {
    "admin": false,
    "chapterTops": [],
    "coinCount": 0,
    "collectIds": [],
    "email": "",
    "icon": "",
    "id": 139230,
    "nickname": "lujunjie",
    "password": "",
    "publicName": "lujunjie",
    "token": "",
    "type": 0,
    "username": "lujunjie"
},
    "errorCode": 0,
    "errorMsg": ""
}*/


data class User(val admin: Boolean,
                val chapterTops: List<String>,
                val collectIds: List<Int>,
                val email: String,
                val icon: String,
                val id: Int,
                val nickname: String,
                val password: String,
                val publicName: String,
                val token: String,
                val type: Int,
                val username: String){

    override fun equals(other: Any?): Boolean {
        return if (other is User){
            this.id == other.id
        }else false
    }
}
