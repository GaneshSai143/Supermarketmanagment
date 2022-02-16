import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-getuserlist',
  templateUrl: './getuserlist.component.html',
  styleUrls: ['./getuserlist.component.css']
})
export class GetuserlistComponent implements OnInit {
  displayedColumns = [ 'firstName', 'lastName', 'emailId','role','action'];
  dataSource: MatTableDataSource<User>|any;
  public pageSize = 10;
  public currentPage = 0;
  public totalSize = 0;
  public array: any;
  
  @ViewChild(MatPaginator) paginator: MatPaginator|any;
  @ViewChild(MatSort) sort: MatSort|any;
  users:User[]=[];
  delete:boolean=false;
  dele:boolean=false;
  constructor(private userservice:UserserviceService,private router:Router) { }

  ngOnInit(): void {
    this.getusers();
    this.getArray();
   // this.createuser();
  }

  private getArray() {
    this.userservice.getusersList()
      .subscribe((response:any) => {
        this.dataSource = new MatTableDataSource<Element>(response);
        this.dataSource.paginator = this.paginator;
        this.array = response;
        this.totalSize = this.array.length;
      });
  }
  private getusers(){
    this.userservice.getusersList().subscribe(data => {this.users=data;});
  }

  updateuser(id:number){
    this.router.navigate(['updateuser',id]);
  }
  deleteuser(id:number){
    this.userservice.deleteuser(id).subscribe(data =>{
      if(data===null){
        this.delete=false;
        this.dele=true;
      }
      else{
        this.delete=true;
      }
      console.log(data);
      this.getusers();
    })
  }

  userDetails(id:number){
    this.router.navigate(['getuserbyid',id]);
  }
  clear()
  {
    this.delete=false;
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value
    this.dataSource.filter = filterValue.trim().toLowerCase();
}
  onChangePage(pe:PageEvent) {
    console.log(pe.pageIndex);
    console.log(pe.pageSize);
  }
  firstLastButtons=true;
  goback()
  {
    this.router.navigate(['sucess']);
  }

}
