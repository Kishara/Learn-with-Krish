import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateOrderComponent } from './create-order/create-order.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { CheckOrdersComponent } from './check-orders/check-orders.component';
import { DispatchComponent } from './dispatch/dispatch.component';
import { OrderReceivedComponent } from './order-received/order-received.component';

const routes: Routes = [
  {path: 'allorders', component: AllOrdersComponent},
  {path: '', redirectTo: 'createorder', pathMatch: 'full'},
  {path: 'createorder', component: CreateOrderComponent},
  {path: 'getorderscomplete', component: OrderReceivedComponent},
  {path: 'getorders', component: CheckOrdersComponent},
  {path: 'dispatch', component: DispatchComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
