import { Component, OnInit } from '@angular/core';
import { OrderModel } from '../orderModel';
import { OrderService } from '../order.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css']
})
export class CreateOrderComponent implements OnInit {

  orderModel:OrderModel = new OrderModel();
  constructor(private orderService:OrderService,) { }

  ngOnInit(): void {
  }

  createOrder(){
    this.orderService.createOrder(this.orderModel).subscribe(data => {
      console.log(this.orderModel);
    },
    error => console.log(error))
    
  }

  realodPage(){
    location.reload();
  }

}