import axios from 'axios';
import { useEffect, useState } from 'react';
import Charts from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/request';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    // 

    /* Trabalhando com o estado do componente
     * Hook: useState => Manter estado no componente
        Hook: useEffect => Executar algo na instanciação ou destruição do componente, observar estado
     */
    const [ chartData, setChartData] = useState<ChartData>({ labels: [], series: []});

    useEffect( () => {
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
        .then(response => {
            const data = response.data as SaleSum[];
            const myLabels = data.map(obj => obj.sellerName);
            const mySeries = data.map(obj => obj.sum);

            setChartData({ labels: myLabels, series: mySeries});
        });
    }, []);

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