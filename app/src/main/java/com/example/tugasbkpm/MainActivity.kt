package com.example.tugasbkpm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasbkpm.acara9.LinearActivity
import com.example.tugasbkpm.ui.theme.ProjectLinearLayoutTheme
import com.example.tugasbkpm.acara17.FragmentMain
import com.example.tugasbkpm.acara21.IntentExplicit
import com.example.tugasbkpm.acara21.IntentImplicit
import com.example.tugasbkpm.acara25.SqlLiteFrist
import com.example.tugasbkpm.acara28.DataHelperMain
import com.example.tugasbkpm.acara31.LoginActivity

class MainActivityCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectLinearLayoutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val menus = listOf(
        "(Acara 9) Linear Layout" to Intent(context, LinearActivity::class.java),
        "(Acara 9) Relative Layout" to Intent(context, RelativeActivity::class.java),
        "(Acara 10) Constraint Layout" to Intent(context, ConstraintActivity::class.java),
        "(Acara 10) Frame Layout" to Intent(context, FrameActivity::class.java),
        "(Acara 11) Table Layout" to Intent(context, TableActivity::class.java),
        "(Acara 11) Material Design" to Intent(context, MaterialDesignActivity::class.java),
        "(Acara 12) Scroll View" to Intent(context, ScrollViewActivity::class.java),
        "(Acara 12) Horizontal Scroll View" to Intent(context, HorizontalScrollViewActivity::class.java),
        "(Acara 15) RecyclerView" to Intent(context, RecylerView::class.java),
        "(Acara 15) RecyclerView15_16" to Intent(context, Recyler15_16::class.java),
        "(Acara 15) Card View" to Intent(context, MahasiswaActivity::class.java),
        "(Acara 17) Fragment" to Intent(context, FragmentMain::class.java),
        "(Acara 21) Intent Implicit" to Intent(context, IntentImplicit::class.java),
        "(Acara 23) Intent Explicit" to Intent(context, IntentExplicit::class.java),
        "(Acara 26) SQlLITE" to Intent(context, SqlLiteFrist::class.java),
        "(Acara 28) Manage SqlLite" to Intent(context, DataHelperMain::class.java),
        "(Acara 31) Preference Shared" to Intent(context, LoginActivity::class.java)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        itemsIndexed(menus) { index, item ->
            MenuButton(
                number = (index + 1).toString(),
                label = item.first,
                onClick = { context.startActivity(item.second) }
            )
        }
    }
}

@Composable
fun MenuButton(number: String, label: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(if (isPressed) 0.95f else 1f, label = "scale")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .scale(scale)
                .shadow(8.dp, CircleShape)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE3EF26), Color(0xFF076653), Color(color = 0xFF0C342C)),
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(80f, 80f)
                    )
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = ripple(color = Color.White)  // Migrasi: Ganti rememberRipple dengan ripple
                ) { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number,
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                modifier = Modifier.padding(4.dp)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    ProjectLinearLayoutTheme {
        MainScreen()
    }
}