import axios from 'axios';
import Charts from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/request';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    // Forma errada
    let chartData : ChartData = { labels: [], series: []};

    // Forma errada de chamar dados na API
   axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(obj => obj.sellerName);
            const mySeries = data.map(obj => obj.sum);

            chartData = { labels: myLabels, series: mySeries};
            console.log(response.data);
        });
    //const mockData = {
    //    series: [477138, 499928, 444867, 220426, 473088],
    //    labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}
    
    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Charts 
            options ={{ ...options, labels: chartData.labels}}
            series = {chartData.series}
            type = "donut"
            height = "240"
         />
    );
}

export default DonutChart;