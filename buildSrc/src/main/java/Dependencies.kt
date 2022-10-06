

object Versions {

    //main
    val kotlin_version = "1.8.0"
    val compose_version = "1.1.0-beta01"
    val androidxLifecycle_version = "2.3.1"
    val androidxActivity_version = "1.3.1"
    val androidMaterialDesign_version = "1.6.1"

    //coroutines
    val coroutineCore_version = "1.5.0"
    val coroutineAndroid_version = "1.5.1"

    //Dagger Hilt
    val daggerHilt_version = "2.38.1"
    val daggerCompiler_version = "2.37"
    val daggerHiltCompiler = "1.0.0"

    //Room
    val room_version = "2.3.0"

    //unit tests
    val androdXTestCore_version = "1.4.0"
    val junitTest_version = "4.13.2"
    val androidcArch_version = "2.1.0"
    val kotlinCoroutineTest_version = "1.5.2"
    val googleTruth_version = "1.1.3"
    val okHttp_version = "4.9.1"
    val mocck_version = "1.10.5"
    val composeTest_version = "1.3.0-beta03"

    //instrumentation tests
    val daggerHiltTesting_version = "2.37"
    val androidExtJunitTest_version = "1.1.3"
    val androidxCoreKtx_version = "1.4.0"
    val androidxTestRunner_version = "1.4.0"

    //navigation
    val androidNavigation_version = "2.5.2"
    val hiltNavigation_version = "1.0.0"

    // compose preview
    val composePreview_version = "1.2.1"

    //lottie
    val lottie_version = "5.2.0"

}

object Deps {

    //main
    val kotlin_core = "androidx.core:core:${Versions.kotlin_version}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose_version}"
    val compose_material = "androidx.compose.material:material:${Versions.compose_version}"
    val compose_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
    val androidx_lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidxLifecycle_version}"
    val androidx_activity = "androidx.activity:activity-compose:${Versions.androidxActivity_version}"
    val androidMaterialDesign = "com.google.android.material:material:${Versions.androidMaterialDesign_version}"

    //coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCore_version}"
    val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroid_version}"

    //Dagger Hilt
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt_version}"
    val daggerHilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerCompiler_version}"
    val daggerHilt_hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.daggerHiltCompiler}"

    //Room
    val roomRuntime = "androidx.room:room-runtime:${Versions.room_version}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room_version}"

    //Unit tests
    val androdXTestCore = "androidx.test:core:${Versions.androdXTestCore_version}"
    val junitTest = "junit:junit:${Versions.junitTest_version}"
    val androidcArch = "androidx.arch.core:core-testing:${Versions.androidcArch_version}"
    val kotlinCoroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineTest_version}"
    val googleTruth = "com.google.truth:truth:${Versions.googleTruth_version}"
    val okHttp = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp_version}"
    val mocck = "io.mockk:mockk:${Versions.mocck_version}"
    val composeTest = "androidx.compose.ui:ui-test-manifest:${Versions.composeTest_version}"

    //Instrumented Tests
    val daggerHiltTesting = "com.google.dagger:hilt-android-testing:${Versions.daggerHiltTesting_version}"
    val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltTesting_version}"
    val androidExtJunitTest = "androidx.test.ext:junit:${Versions.androidExtJunitTest_version}"
    val androidxCoreKtx = "androidx.test:core-ktx:${Versions.androidxCoreKtx_version}"
    val androidxTestRunner = "androidx.test:runner:${Versions.androidxTestRunner_version}"

    //Navigation
    val androidxNavigation = "androidx.navigation:navigation-compose:${Versions.androidNavigation_version}"
    val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation_version}"

    //Compose preview
    val composePreviewTooling = "androidx.compose.ui:ui-tooling:${Versions.composePreview_version}"
    val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composePreview_version}"

    //Lottie
    val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie_version}"

}