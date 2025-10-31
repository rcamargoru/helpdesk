import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export default class ProfileComponet{
  roles: string[] = [];

  constructor(private activatedRoute: ActivatedRoute) { 
    const navigation = history.state;
    this.roles = navigation['roles'] || [];
    console.log('Roles recibidos:', this.roles);
  }


}
