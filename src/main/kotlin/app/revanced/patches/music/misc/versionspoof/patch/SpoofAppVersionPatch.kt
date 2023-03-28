package app.revanced.patches.music.misc.versionspoof.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.music.misc.settings.patch.MusicSettingsPatch
import app.revanced.patches.shared.annotation.YouTubeMusicCompatibility
import app.revanced.patches.shared.patch.versionspoof.GeneralVersionSpoofPatch
import app.revanced.util.integrations.Constants.MUSIC_SETTINGS_PATH

@Patch
@Name("spoof-version")
@Description("Spoof the YouTube Music client version.")
@DependsOn(
    [
        GeneralVersionSpoofPatch::class,
        MusicSettingsPatch::class
    ]
)
@YouTubeMusicCompatibility
@Version("0.0.1")
class SpoofAppVersionPatch : BytecodePatch() {
    override fun execute(context: BytecodeContext): PatchResult {

        GeneralVersionSpoofPatch.injectSpoof("$MUSIC_SETTINGS_PATH->spoofVersion(Ljava/lang/String;)Ljava/lang/String;")

        MusicSettingsPatch.addMusicPreference("navigation", "revanced_enable_spoof_version", "false")

        return PatchResultSuccess()
    }
}