import { Component, OnInit } from '@angular/core';
import { OrderModel} from '../orderModel'
import { OrderService } from '../order.service';
@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css']
})
export class AllOrdersComponent implements OnInit {

  orders!: OrderModel[];
  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.getAllOrders();
  }

  private getAllOrders(){
    this.orderService.getAllOrders().subscribe(data =>{
      this.orders = data;
      console.log(data);
    })
  }

}
