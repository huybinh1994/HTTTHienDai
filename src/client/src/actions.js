import Request from "superagent";

const java_service_url = "http://192.168.1.136:8080/DoAnCuoiKy";

export const login = (username, password) => {
    Request.post(java_service_url + '/login')
    .send({
        username: "binh",
        password: "123456"
    })
    .end((err, res) => {
        console.error(err);
        console.log(res);
    })
    ;
}