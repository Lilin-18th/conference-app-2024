package io.github.droidkaigi.confsched.model

import androidx.compose.runtime.Composable
import io.github.droidkaigi.confsched.model.compositionlocal.LocalRepositories
import kotlinx.collections.immutable.PersistentSet
import kotlinx.coroutines.flow.Flow

interface AchievementRepository {
    fun getAchievementEnabledStream(): Flow<Boolean>
    fun getAchievementDetailDescriptionStream(): Flow<String>
    fun getResetAchievementsEnabledStream(): Flow<Boolean>
    fun getAchievementsStream(): Flow<PersistentSet<Achievement>>
    fun getIsInitialDialogDisplayStateStream(): Flow<Boolean>
    suspend fun saveAchievements(achievement: Achievement)
    suspend fun resetAchievements()
    suspend fun displayedInitialDialog()
}

@Composable
fun localAchievementRepository(): AchievementRepository {
    return LocalRepositories.current[AchievementRepository::class] as AchievementRepository
}