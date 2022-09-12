import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderModel } from '../orderModel';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-order-received',
  templateUrl: './order-received.component.html',
  styleUrls: ['./order-received.component.css']
})
export class OrderReceivedComponent implements OnInit {

  id!:number;
  orders!: OrderModel[];
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {}

   getOrderById(){
    this.orderService.getOrderById(this.id).subscribe(data =>{
      this.orders = data;
      console.log(data);
    },
    error => console.log(error));
  }

  getOrderComplete(orderId:number){
    this.orderService.getOrderComplete(orderId,"Completed").subscribe(data =>{
      console.log(data);
      this.getOrderById();
    },
    error => console.log(error));
  }
  
  

}
