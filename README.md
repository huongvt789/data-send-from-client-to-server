# data-send-from-client-to-server
Thực hành lập trình phân tán
# Đề bài:
1.Cài đặt chương trình phân tán sau sử dụng socket trên UDP, TCP hoặc sử dụng RMI. Ưu tiên sử dụng RMI.
2. Chương trình gồm một server và một hoặc nhiều client.
3. Client gửi một dãy số nguyên lên server, mỗi số phân tách nhau bằng ký tự trắng.
4. Server tìm dãy con có tổng lớn nhất của dãy nhận được, sau đó trả về cho client tổng đó cùng vị trí bắt đầu và kết thúc của dãy con.
5. Lưu ý: vị trí bắt đầu tính từ 1.
Ví dụ:

# Cách 1: Run demo.
1. git clone https://github.com/huongvt789/data-send-from-client-to-server.git
2. Run trên trình biên dịch Eclipe.
2.1. File AppServer.java 
2.2 File AppClient.java (Nhap day so va xem ket qua)

# Cách 2: Tự cài đặt
1. Tạo 1 thu muc java project.
2. Tạo 3 packet và các class: component(class AbstractChatComponent, Client, Server), 
test (AppClient, AppServer), util(Closing).
3. Cài đặt lớp.
4. Tiến hành chạy: class test/AppClient => class test/AppServer.

Kết quả đạt được:
1. Client gui len server day so la : : 
-2 11 -4 13 -5 2
2. Server tra ve: Tong so 20 Vi tri bat dau :2 Vi tri ket thuc :4

