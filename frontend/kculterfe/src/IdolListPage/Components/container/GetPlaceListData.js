import axios from 'axios';

export async function getPlaceList() {
    let list;
    //await 한 값을 보내준다.
    return await axios.get('/places', {
        responseType: 'json'
    })
    .then(function(res){
        list = res.data;
        console.log(list);
        return list;
    })
    .catch(function(error){
        console.log(error);
        alert("서버 통신 실패");
    });
}

