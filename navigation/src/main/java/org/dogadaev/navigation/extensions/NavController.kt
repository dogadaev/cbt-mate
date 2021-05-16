package org.dogadaev.navigation.extensions

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import org.dogadaev.navigation.Navigator
import org.dogadaev.navigation.NavigatorImpl
import org.dogadaev.navigation.R
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class NavControllerDelegate (
    application: Application
) : ReadOnlyProperty<Navigator, NavController> {

    private var navController: NavController? = null

    init {
        application.registerActivityLifecycleCallbacks(
            object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) = Unit
                override fun onActivityStarted(activity: Activity) = Unit
                override fun onActivityResumed(activity: Activity) {
                    if (navController != null) return

                    val fragmentManager = (activity as AppCompatActivity).supportFragmentManager
                    val navHostFragment = fragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment

                    navController = navHostFragment.navController
                }
                override fun onActivityPaused(activity: Activity) = Unit
                override fun onActivityStopped(activity: Activity) = Unit
                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit
                override fun onActivityDestroyed(activity: Activity) {
                    navController = null
                }
            }
        )
    }

    override fun getValue(thisRef: Navigator, property: KProperty<*>): NavController {
        val navController = navController

        if (navController != null) return navController
        else throw KotlinNullPointerException("NavController is null.")
    }
}

internal fun NavigatorImpl.onNavHostReady(
) = NavControllerDelegate(application)