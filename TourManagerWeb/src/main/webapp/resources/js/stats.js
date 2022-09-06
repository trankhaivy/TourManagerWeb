/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`
}

function tourChart(id,tourLabels=[],tourInfo=[]){
    let colors = []
    for (let i=0;i<tourInfo.length;i++)
        colors.push(generateColor())
    
    const data={
        labels:tourLabels,
        datasets:[
            {
                label:'Thong ke tour theo doanh thu',
                data:tourInfo,
                backgroundColor:colors,
                bolder:colors,
                hoverOffset:4
            }
        ]
    };
    
    const config={
        type:'line',
        data:data
    };
    
    let ctx= document.getElementById(id).getContext("2d")
    new Chart(ctx,config)
}

function tourMonthChart(id,tourLabels=[],tourInfo=[]){
    let colors = []
    for (let i=0;i<tourInfo.length;i++)
        colors.push(generateColor())
    
    const data={
        labels:tourLabels,
        datasets:[
            {
                label:'Thong ke doanh thu theo thang',
                data:tourInfo,
                backgroundColor:colors,
                bolder:colors,
                hoverOffset:4
            }
        ]
    };
    
    const config={
        type:'bar',
        data:data
    };
    
    let ctx= document.getElementById(id).getContext("2d")
    new Chart(ctx,config)
}

function tourQuarterChart(labels, data) {
    const ctx = document.getElementById('myTourQuarterChart').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Thong ke doanh thu theo quy',
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

