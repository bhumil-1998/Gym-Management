import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { PaginationService } from '../../Shared/PaginationService';
import { MemberRegistrationModel } from '../Models/app.MemberRegistrationModel';
import { MemberRegistrationService } from '../Services/app.MemberRegistration.Service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-overview',
    templateUrl: 'app.MemberViewComponent.html'
 
})

export class MemberViewComponent implements OnInit {

    dataSource: MemberRegistrationModel[];
    totalCount: number;

    constructor(
        private _Route: Router,
        private memberregistration: MemberRegistrationService,
        private paginationService: PaginationService) { }

    ngOnInit(): void {
        this.getAllMembers();
    }

    switchPage(event: PageEvent) {
        this.paginationService.change(event);
        this.getAllMembers();
    }

    getAllMembers() {
        this.memberregistration.getAll<MemberRegistrationModel[]>()
            .subscribe((result: any) => 
            {
                // this.totalCount = JSON.parse(result.headers.get('X-Pagination')).totalCount;
                this.totalCount = result.body.totalCount;
               // this.totalCount = 4;
               this.dataSource = result.body.value;
               
               
            });           
    }

  
      

    
}
