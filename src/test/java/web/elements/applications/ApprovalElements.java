package web.elements.applications;

import element.GenericElement;
import org.openqa.selenium.By;

public class ApprovalElements {
    public static final GenericElement SEND_TO_APPROVAL_BUTTON = new GenericElement("Отправить на согласование",
            By.xpath("//a[@id = 'sendToApprovalButton']"));
    public static final GenericElement APPROVE_BUTTON = new GenericElement("Отправить на согласование",
            By.xpath("//a[@id = 'approveButton']"));
    public static final GenericElement REVIEW_PERSONS = new GenericElement("Участвующие в рассмотрении", By.xpath("//a[@id = 'review']"));
    public static final GenericElement APPROVE_PERSONS = new GenericElement("Участвующие в согласовании", By.xpath("//a[@id = 'approve']"));
    public static final GenericElement SEND_PERSONS = new GenericElement("Отправить на ознакомление", By.xpath("//a[@id = 'send']"));
    public static final GenericElement SELECT_BUTTON = new GenericElement ("Выберите участников",
            By.xpath("//button[@id = 'participantListPopover']"));
    public static final GenericElement SELECT = new GenericElement ("Выберите участника",
            By.xpath("//div[@id = 'part-list']//input[@type = 'checkbox']"));
    public static final GenericElement OK_BUTTON = new GenericElement ("Ok",
            By.xpath("//*[contains(text(), 'Ок')]"));
    public static final GenericElement SUCCESS_MESSAGE = new GenericElement ("Заявка успешно согласована",
            By.xpath("//span[@id = 'successMessage']"));
}
