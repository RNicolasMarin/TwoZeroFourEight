package com.example.two_zero_four_eight.presentation.design_system

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val minScreenWidth = 320.dp
val minScreenHeightIncludingSimplified = 240.dp

@Preview(name = "320x480PortFull", widthDp = 320, heightDp = 480)
@Preview(name = "320x480LandFull", widthDp = 480, heightDp = 320)
@Preview(name = "320x480PortSimp", widthDp = 320, heightDp = 240)
@Preview(name = "320x480LandSimp", widthDp = 240, heightDp = 320)
annotation class DevicePreview320x480

/*@Preview(name = "1440x3200PortFull", widthDp = 1440, heightDp = 3200)
@Preview(name = "1440x3200LandFull", widthDp = 3200, heightDp = 1440)
@Preview(name = "1440x3200PortSimp", widthDp = 1440, heightDp = 1600)
@Preview(name = "1440x3200LandSimp", widthDp = 1600, heightDp = 1440)
annotation class DevicePreview1440x3200*/

@DevicePreview320x480
annotation class MultiDevicePreview