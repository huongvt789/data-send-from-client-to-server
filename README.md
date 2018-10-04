# data-send-from-client-to-server
Thực hành lập trình phân tán
# Đề bài:
Cài đặt chương trình phân tán sau sử dụng socket trên UDP, TCP hoặc sử dụng RMI. Ưu tiên sử dụng RMI.
Chương trình gồm một server và một hoặc nhiều client.
Client gửi một dãy số nguyên lên server, mỗi số phân tách nhau bằng ký tự trắng.
Server tìm dãy con có tổng lớn nhất của dãy nhận được, sau đó trả về cho client tổng đó cùng vị trí bắt đầu và kết thúc của dãy con.
Lưu ý: vị trí bắt đầu tính từ 1.
Ví dụ:
client gửi lên server dãy số: -2 11 -4 13 -5 2
server trả về Tổng: 20, Vị trí bắt đầu: 2, Vị trí kết thúc: 4
# Cách 1: Run demo.
B1: git clone https://github.com/huongvt789/data-send-from-client-to-server.git
B2: Run trên trình biên dịch Eclipe.
1. File AppServer.java 
2. File AppClient.java (Nhap day so va xem ket qua)

# Cách 2: Tự cài đặt
B1: Tạo 1 thu muc java project.
B2: Tạo 3 packet và các class: component(class AbstractChatComponent, Client, Server), 
test (AppClient, AppServer), util(Closing).
B3: Cài đặt lớp.
B4. Tiến hành chạy: class test/AppClient => class test/AppServer.

Kết quả đạt được:
Client gui len server day so la : : 
-2 11 -4 13 -5 2
Server tra ve: Tong so 20 Vi tri bat dau :2 Vi tri ket thuc :4

