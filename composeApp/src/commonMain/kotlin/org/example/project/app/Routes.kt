package org.example.project.app
import kotlinx.serialization.Serializable

   sealed interface Routes {
       val route: String

       @Serializable
       data object LogIn : Routes {
           override val route: String = "login"
       }

       @Serializable
       data object CharacterList : Routes {
           override val route: String = "character_list"
       }

       @Serializable
       data object CharacterDetail : Routes {
          override val route: String = "character_detail"
       }
   }
