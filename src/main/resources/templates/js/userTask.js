document.addEventListener('DOMContentLoaded', function () {
    var params = JSON.parse(localStorage.getItem('userLogin'));
    const url = 'http://localhost:8080/findByParentId';
    params['id'] = "0";
    loadTasks(url, params);
});
async function loadTasks(url, params) {
    try {
        let value = await axios.post(url, params);
        parentTaskLoader(url, value.data, params);
    } catch (e) {
        console.log(e)
    }
}
function parentTaskLoader(url, data, params){
    var parentTasks = document.getElementById("parentTasks");
    var task;
    for(task of data){
        const taskItem = document.createElement('div');
        taskItem.className ="listItem";
        taskItem.innerHTML = task.description;
        taskItem.id = task.id;
        taskItem.addEventListener('click', function(event) {
            childTaskLoader(event.target, url, params);
        });
        parentTasks.appendChild(taskItem);
    }
}

async function childTaskLoader(element, url, params){
    params['id'] = element.id;
    let value = await axios.post(url, params);
    console.log(value.data);
    var parentTasks = document.getElementById("childTasks");
    parentTasks.innerHTML="";
    for(task of value.data){
        console.log(task);
        const taskItem = document.createElement('div');
        taskItem.className ="listItem";
        taskItem.innerHTML = task.description;
        taskItem.id = task.id;
        taskItem.addEventListener('click', function(event) {
            childTaskLoader(event.target, url, params);
        });
        childTasks.appendChild(taskItem);
    }
}