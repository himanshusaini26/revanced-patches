package app.revanced.patches.youtube.misc.playercontrols.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object PlayerControlsVisibilityFingerprint : MethodFingerprint(
    returnType = "V",
    parameters = listOf("Z", "Z"),
    customFingerprint = { it, _ -> it.definingClass.endsWith("YouTubeControlsOverlay;") }
)