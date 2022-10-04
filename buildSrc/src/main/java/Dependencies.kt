

object Versions {

    //main
    val kotlin_version = "1.8.0"
    val compose_version = "1.1.0-beta01"
    val androidxLifecycle_version = "2.3.1"
    val androidxActivity_version = "1.3.1"

    //coroutines
    val corroitineCore_version = "1.5.0"
    val coroutineAndroid_version = "1.5.1"

    //Dagger Hilt
    val daggerHilt_version = "2.38.1"
    val daggerCompiler_version = "2.37"
    val daggerHiltCompiler = "1.0.0"


}

object Deps {

    //main
    val kotlin_core = "androidx.core:core:${Versions.kotlin_version}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose_version}"
    val compose_material = "androidx.compose.material:material:${Versions.compose_version}"
    val compose_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
    val androidx_lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle_version}"
    val androidx_activity = "androidx.activity:activity-compose:${Versions.androidxActivity_version}"

    //coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.corroitineCore_version}"
    val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroid_version}"

    //Dagger Hilt
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt_version}"
    val daggerHilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerCompiler_version}"
    val daggerHilt_hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.daggerHiltCompiler}"
}