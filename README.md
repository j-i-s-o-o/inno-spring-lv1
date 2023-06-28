# inno-spring-lv1
# UseCase

유진유진정 작품
<td><img width="1000" src="https://raw.githubusercontent.com/kkamjjing-i/LevelByOne/fb9419f531def04eda909e752054eaf5d3aa0baf/%EC%A0%9C%EB%AA%A9%20%EC%97%86%EB%8A%94%20%EB%8B%A4%EC%9D%B4%EC%96%B4%EA%B7%B8%EB%9E%A8-%ED%8E%98%EC%9D%B4%EC%A7%80-1.drawio.png" /> </td>

지수지수안 작품
<td><img width="1000" src="https://user-images.githubusercontent.com/135205241/249213292-6a00fa28-f93d-435c-b599-14f2dd8f8709.png" /> </td>

정환정환박 네비


# API 명세

| Method | 기능 | URL | Request | Response |
| --- | --- | --- | --- | --- |
| POST | 게시글 생성 | /api/board/{id} | {
"title": "{title}",
"contents": "{contents}"
} | {
"id": {id},
"title": "{title}",
"username": "{username}",
"contents": "{contents}",
"createdAt": "2023-06-28T09:04:06.2416137"
} |
| GET | 전체 게시글 조회 | /api/boards | - | [
{
"id": {id},
"title": "{title}",
"username": "{username}",
"contents": "{contents}",
"createdAt": "{LocalDateTime}"
}
] |
| GET | 선택 게시글 조회 | /api/board/{id} | - | {
"id": {id},
"title": "{title}",
"username": "{username}",
"contents": "{contents}",
"createdAt": "{LocalDateTime}"
}} |
| PUT  | 게시글 수정 | /api/board/{id} | {
"title" : "{title}",
"username" : "{username}",
"password" : "{password}",
"contents" : "{contents}"
} | {
"title" : "{title}",
"username" : "{username}",
"date" : "{date}",
"contents" : "{contents}"
} |
| DELETE | 게시글 삭제 | /api/board/{id} | {
"password" : "password"
} | {
"msg" : "삭제 됐어❤️" ||  "삭제 안 됐어❤️
} |
