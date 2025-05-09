import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Immutable
import kotlinx.coroutines.flow.emptyFlow

@Immutable
class NoRippleInteractionSource : MutableInteractionSource {
    override val interactions = emptyFlow<Interaction>()

    override suspend fun emit(interaction: Interaction) { }

    override fun tryEmit(interaction: Interaction): Boolean = true
}