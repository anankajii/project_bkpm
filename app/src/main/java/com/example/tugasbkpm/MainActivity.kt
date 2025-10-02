package com.example.tugasbkpm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ripple
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
import androidx.compose.ui.text.style.TextAlign
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
import com.example.tugasbkpm.acara33.Map
import com.example.tugasbkpm.acara34.Maps
import com.example.tugasbkpm.acara35.MainActivity

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
        "(Acara 31) Preference Shared" to Intent(context, LoginActivity::class.java),
        "(Acara 33) Maps" to Intent(context, Map::class.java),
        "(Acara 34) Maps" to Intent(context, Maps::class.java),
        "(Acara 35) Sensor" to Intent(context, MainActivity::class.java),
        "(Acara 36) Sensor" to Intent(context, com.example.tugasbkpm.acara36.MainActivity::class.java),
        "(Acara 37) Json" to Intent(context, com.example.tugasbkpm.acara37.JsonActivity::class.java),
        "(Acara 38) Json" to Intent(context, com.example.tugasbkpm.acara38.JsonApiActivity::class.java),
        "(Acara 38) Json Parse" to Intent(context, com.example.tugasbkpm.acara38.JsonParseActivity::class.java),
        "(Acara 39) Movie" to Intent(context, com.example.tugasbkpm.acara39.MovieDbActivity::class.java),
        "(Acara 40) JSON AND API" to Intent(context, com.example.tugasbkpm.acara40.MainActivitiy::class.java),
        "(Acara 41) From Login R" to Intent(context, com.example.tugasbkpm.acara41.LoginActivity::class.java)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A237E),
                        Color(0xFF283593),
                        Color(0xFF3949AB),
                        Color(0xFF5E35B1)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Grid Menu
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(menus) { index, item ->
                    MenuButton(
                        number = (index + 1).toString(),
                        label = item.first,
                        onClick = { context.startActivity(item.second) }
                    )
                }
            }

            // Watermark Footer
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0D47A1).copy(alpha = 0.9f))
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "© KAJI STD",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF82B1FF),
                        letterSpacing = 2.sp
                    )
                    Text(
                        text = "Mobile Development 2025",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFFBBDEFB)
                    )
                }
            }
        }
    }
}

@Composable
fun MenuButton(number: String, label: String, onClick: () -> Unit) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.92f else 1f,
        animationSpec = tween(100),
        label = "scale"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(100.dp)
    ) {
        Box(
            modifier = Modifier
                .size(75.dp)
                .scale(scale)
                .shadow(
                    elevation = 12.dp,
                    shape = CircleShape,
                    spotColor = Color(0xFF448AFF).copy(alpha = 0.6f)
                )
                .clip(CircleShape)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF448AFF),
                            Color(0xFF2979FF),
                            Color(0xFF1565C0)
                        )
                    )
                )
                .clickable(
                    interactionSource = interactionSource,
                    indication = ripple(color = Color.White)
                ) { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number,
                fontSize = 26.sp,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 13.sp
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