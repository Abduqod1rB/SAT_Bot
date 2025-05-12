package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.List;

public class MyBotService {

    // Menyu yaratish va qaytarish
    public SendMessage menu(Long chatId) {
        // Inline tugmalarni sozlash
        ReplyKeyboardMarkup reply = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();

        // 1-row: Math va English tugmalari
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("📘 Math"));
        row1.add(new KeyboardButton("📗 English"));

        // 2-row: Grammar va SAT Practice tugmalari
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("📚 Vocabulary"));
        row2.add(new KeyboardButton("\uD83D\uDCDD Practice"));

        // 3-row: Useful Links va Desmos Solution tugmalari
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("\uD83D\uDCCD Location"));

        KeyboardButton button = new KeyboardButton();
        button.setText("🧮 Desmos");
        WebAppInfo webAppInfo = new WebAppInfo("https://www.desmos.com/testing/cb-sat-ap/graphing");
        button.setWebApp(webAppInfo);
        row3.add(button);

        KeyboardRow row4 = new KeyboardRow();
        row4.add(new KeyboardButton("\uD83D\uDDD3 Registration service"));

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);


        reply.setKeyboard(rowList);
        reply.setResizeKeyboard(true); // Klaviaturani hajmini avtomatik ravishda moslashtirish

        String welcomeText = """
                👋 *Assalomu alaykum! Xush kelibsiz!*
                
                Siz bu yerda SAT imtihoni uchun kerakli materiallarni topishingiz mumkin:
                - Matematika (Algebra, Geometriya)
                - Ingliz tili (Reading, Writing, Grammar)
                - Desmos bilan yechimlar
                - SAT Practice va havolalar
                
                Iltimos, kerakli bo‘limni tanlang 👇
                """;

        // SendMessage obyektini yaratish va chatga yuborish
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(welcomeText); // Xush kelibsiz matni
        sendMessage.setParseMode("Markdown"); // Markdown formatini qo'llash
        sendMessage.setReplyMarkup(reply); // Klaviatura ni o'rnatish

        return sendMessage;
    }
}
