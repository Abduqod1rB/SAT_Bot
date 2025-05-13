package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    static MyBotService myBotService = new MyBotService();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            switch (text) {
                case "/start" -> executeSafely(myBotService.menu(chatId));
                case "📘 Math" -> sendMathTopics(chatId);
                case "📗 English" -> sendEnglishTopics(chatId);
                case "🧮 Desmos" -> sendText(chatId, "Desmos: https://www.desmos.com/calculator");
                case "📚 Vocabulary" ->sendVocabulary(chatId);
                case "\uD83D\uDD17 Online Practice Platforms"-> sendText1(chatId, "https://bluebook.plus\n https://oneprep.fly.dev\n");
                case "\uD83D\uDCCD Test Centers"->sendText(chatId,"SAT location: ");
                case "\uD83D\uDCDD Register for SAT"->sendText(chatId,"Registratsiya boyicha savollar bolsa ushbu lichkaga murojaat qiling\n @abu_org");
                case "\uD83D\uDCAC Contact Admin" ->sendText(chatId," @abu_org");
                default -> sendText(chatId, "Iltimos, menyudagi tugmalardan foydalaning.");
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "SATmaterials2025_bot";
    }

    @Override
    public String getBotToken() {
        return "7035941281:AAHnhuEADA_Vg-TYd5HQBPilkJ76YCAa-6g";
    }

    public SendMessage sendMessage (Long chatId  , String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        return sendMessage;
    }

    // Send topic buttons to the user
    private void sendMathTopics(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // Adding buttons to the list
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Algebra").callbackData("algebra").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Advanced Math").callbackData("advancedM").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Problem-Solving and Data Analysis").callbackData("problemS").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Geometry").callbackData("geometry").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Trigonometry").callbackData("trigonometry").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang:");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }
    private void sendEnglishTopics(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // Adding buttons to the list
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Reading").callbackData("algebra").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📗 Writing").callbackData("geometry").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang:");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendVocabulary(Long chatId) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rows = new ArrayList<>();

        // Adding buttons to the list
        rows.add(List.of(InlineKeyboardButton.builder().text("📘 Math Vocabulary").callbackData("mathVocav").build()));
        rows.add(List.of(InlineKeyboardButton.builder().text("📗 English Vocabulary").callbackData("englishVocab").build()));

        markup.setKeyboard(rows);

        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText("Quyidagi mavzulardan birini tanlang:");
        message.setReplyMarkup(markup);

        executeSafely(message);
    }

    private void sendText(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        executeSafely(message);
    }
    private void sendText1(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId.toString());
        message.setText(text);
        executeSafely(message);
    }

    // Safely execute a Telegram method (sending messages)
    private void executeSafely(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
