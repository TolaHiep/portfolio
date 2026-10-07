package com.example.studentcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Màu sắc lấy theo thẻ thật
private val CardBackground = Color(0xFFF7E9E1) // nền hồng nhạt của thẻ
private val TextDark = Color(0xFF3B3040)       // chữ tím than
private val LineRed = Color(0xFFD32F2F)        // đường kẻ đỏ dưới tiêu đề
private val Watermark = Color(0x1A3B3040)      // chữ "HUST" mờ phía sau

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF1E1E1E)),
                contentAlignment = Alignment.Center
            ) {
                StudentCard()
            }
        }
    }
}

@Composable
fun StudentCard() {
    Column(
        modifier = Modifier
            .width(340.dp)
            .aspectRatio(54f / 85.6f) // tỉ lệ thẻ CR80 dọc
            .shadow(8.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(CardBackground)
            .padding(horizontal = 22.dp, vertical = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardHeader()

        // Đường kẻ đỏ
        Box(
            modifier = Modifier
                .padding(start = 14.dp, end = 4.dp, top = 6.dp)
                .fillMaxWidth()
                .height(1.5.dp)
                .background(LineRed)
        )

        Spacer(Modifier.height(12.dp))

        // Tiêu đề thẻ
        Text(
            text = "THẺ SINH VIÊN",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )
        Text(
            text = "Student ID Card",
            fontSize = 14.sp,
            color = TextDark
        )

        Spacer(Modifier.height(8.dp))

        // Ảnh sinh viên
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Ảnh sinh viên",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(160.dp)
                .height(165.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(Modifier.height(12.dp))

        // Họ tên
        Text(
            text = "NGUYỄN MẠNH HIỆP",
            fontSize = 22.sp,
            fontWeight = FontWeight.ExtraBold,
            color = TextDark,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(4.dp))

        // Trường / Khoa
        Text(
            text = "TRƯỜNG CÔNG NGHỆ THÔNG TIN VÀ TRUYỀN THÔNG",
            fontSize = 9.5.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextDark,
            textAlign = TextAlign.Center,
            maxLines = 1
        )
        Text(
            text = "School of Information and Communications Technology",
            fontSize = 8.5.sp,
            color = TextDark,
            textAlign = TextAlign.Center,
            maxLines = 1
        )

        Spacer(Modifier.weight(1f))

        StudentInfo()
    }
}

@Composable
fun CardHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_hust),
            contentDescription = "Logo Bách Khoa",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 8.dp)
                .width(38.dp)
                .height(54.dp)
        )
        Spacer(Modifier.width(10.dp))
        Column {
            Text(
                text = "ĐẠI HỌC",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                lineHeight = 15.sp
            )
            Text(
                text = "BÁCH KHOA HÀ NỘI",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                lineHeight = 15.sp
            )
            Text(
                text = "HANOI UNIVERSITY",
                fontSize = 9.sp,
                fontWeight = FontWeight.Medium,
                color = TextDark,
                lineHeight = 11.sp
            )
            Text(
                text = "OF SCIENCE AND TECHNOLOGY",
                fontSize = 9.sp,
                fontWeight = FontWeight.Medium,
                color = TextDark,
                lineHeight = 11.sp
            )
        }
    }
}

@Composable
fun StudentInfo() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(1f)) {
            // Chữ "HUST" mờ in chìm phía sau thông tin
            Text(
                text = "HUST",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily.SansSerif,
                color = Watermark,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 10.dp)
            )
            Column {
                InfoRow("Ngày sinh/ DOB", "22/02/2003")
                InfoRow("MSSV/ Student ID", "20215366")
                InfoRow("Khoá/ Intake", "66")
                InfoRow("Giá trị đến/ Valid until", "30/07/2026")
            }
        }
        Spacer(Modifier.width(8.dp))
        Image(
            painter = painterResource(id = R.drawable.qr_code),
            contentDescription = "Mã QR",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(64.dp)
        )
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 1.dp)) {
        Text(
            text = label,
            fontSize = 9.sp,
            color = TextDark,
            modifier = Modifier.width(110.dp)
        )
        Text(
            text = ": $value",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = TextDark
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1E1E1E, widthDp = 380, heightDp = 600)
@Composable
fun StudentCardPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        StudentCard()
    }
}
