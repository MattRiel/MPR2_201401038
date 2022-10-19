import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val name:String?,
    val brand:String?,
    val type:String?,
    val year:Int?,
    val price:Double?
) : Parcelable

